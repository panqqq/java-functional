package com.endava.internship.service;

import com.endava.internship.domain.Privilege;
import com.endava.internship.domain.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.AbstractMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class UserServiceImpl implements UserService {

    @Override
    public List<String> getFirstNamesReverseSorted(List<User> users) {
        return users.stream()
                    .map(User::getFirstName)
                    .sorted(Comparator.reverseOrder())
                    .collect(toList());

    }

    @Override
    public List<User> sortByAgeDescAndNameAsc(final List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge).reversed()
                                    .thenComparing(User::getFirstName))
                .collect(toList());
    }

    @Override
    public List<Privilege> getAllDistinctPrivileges(final List<User> users) {
        return users.stream()
                .flatMap(user -> user.getPrivileges().stream())
                .distinct()
                .collect(toList());
    }

    @Override
    public Optional<User> getUpdateUserWithAgeHigherThan(final List<User> users, final int age) {
        return users.stream()
                .filter(user -> user.getAge() > age && user.getPrivileges().contains(Privilege.UPDATE) )
                .findFirst();
    }

    @Override
    public Map<Integer, List<User>> groupByCountOfPrivileges(final List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(user -> user.getPrivileges().size()));
    }

    @Override
    public double getAverageAgeForUsers(final List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(-1);
    }

    @Override
    public Optional<String> getMostFrequentLastName(final List<User> users) {
        Map<String, Long> map = users.stream()
                .map(User::getLastName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream()
                .filter(a-> a.getValue() > 1)
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

    }

    @Override
    public List<User> filterBy(final List<User> users, final Predicate<User>... predicates) {
        //TODO look4it
        return users.stream()
                .filter(Stream.of(predicates).reduce(x->true, Predicate::and))
                .collect(toList());
    }

    @Override
    public String convertTo(final List<User> users, final String delimiter, final Function<User, String> mapFun) {
        return users.stream()
                .map(mapFun)
                .collect(Collectors.joining(delimiter));
    }

    @Override
    public Map<Privilege, List<User>> groupByPrivileges(List<User> users) {
        return users.stream()
                .flatMap(user -> user.getPrivileges().stream().map(privilege -> new AbstractMap.SimpleEntry<>(privilege, user)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, toList())));
    }

    @Override
    public Map<String, Long> getNumberOfLastNames(final List<User> users) {
        return users.stream()
                .map(User::getLastName)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}
