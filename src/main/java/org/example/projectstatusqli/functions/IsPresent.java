package org.example.projectstatusqli.functions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Optional;

public class IsPresent implements CheckIfPresent{
    private  final Logger logger = LoggerFactory.getLogger(IsPresent.class);

    @Override
    public  <T> void isNotPresent(Optional<T> optional) {
        if (!optional.isPresent()) {
            logger.error("The object does not exist");
            throw new NoSuchElementException("The object does not exist");
        }
    }

    @Override
    public  <T> void isPresent(Optional<T> optional) {
        if (optional.isPresent()) {
            logger.error("The object already exist");
            throw new NoSuchElementException("The object already exist");
        }
    }
}
