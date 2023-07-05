package com.techelevator.util;

import org.springframework.data.relational.core.sql.In;

import java.util.Arrays;
import java.util.List;

public enum ProductionRunStatus {
    Pending {
        @Override
        public ProductionRunStatus nextStatus() {
            return InProgress;
        }

        @Override
        public List<ProductionRunStatus> allowedTransition() {
            return Arrays.asList(Canceled, InProgress);
        }
    },
    InProgress {
        @Override
        public ProductionRunStatus nextStatus() {
            return Completed;
        }

        @Override
        public List<ProductionRunStatus> allowedTransition() {
            return Arrays.asList(Canceled, Completed);
        }
    },
    Completed {
        @Override
        public ProductionRunStatus nextStatus() {
            return null;
        }

        @Override
        public List<ProductionRunStatus> allowedTransition() {
            return null;
        }
    },
    Canceled {
        @Override
        public ProductionRunStatus nextStatus() {
            return null;
        }

        @Override
        public List<ProductionRunStatus> allowedTransition() {
            return null;
        }
    };

    public abstract ProductionRunStatus nextStatus();
    public abstract List<ProductionRunStatus> allowedTransition();
}
