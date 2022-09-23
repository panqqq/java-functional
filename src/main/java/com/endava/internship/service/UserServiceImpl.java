package com.endava.internship.service;

import com.endava.internship.domain.Privilege;
import com.endava.internship.domain.User;
import com.endava.internship.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class UserServiceImpl implements UserService {

    @Override
    public List<String> getFirstNamesReverseSorted(List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<User> sortByAgeDescAndNameAsc(final List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<Privilege> getAllDistinctPrivileges(final List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<User> getUpdateUserWithAgeHigherThan(final List<User> users, final int age) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Map<Integer, List<User>> groupByCountOfPrivileges(final List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public double getAverageAgeForUsers(final List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<String> getMostFrequentLastName(final List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<User> filterBy(final List<User> users, final Predicate<User>... predicates) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public String convertTo(final List<User> users, final String delimiter, final Function<User, String> mapFun) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Map<Privilege, List<User>> groupByPrivileges(List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Map<String, Long> getNumberOfLastNames(final List<User> users) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
