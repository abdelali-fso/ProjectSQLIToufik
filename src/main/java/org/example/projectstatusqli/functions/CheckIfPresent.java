package org.example.projectstatusqli.functions;

import java.util.Optional;

public interface CheckIfPresent {
    <T> void isNotPresent(Optional<T> optional);
    <T> void isPresent(Optional<T> optional);
}
