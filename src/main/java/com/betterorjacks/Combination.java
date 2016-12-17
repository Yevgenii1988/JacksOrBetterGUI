package com.betterorjacks;

public enum Combination {
    ROYAL_FLUSH {
        @Override
        public String getName() {
            return "Royal Flush";
        }
    },
    STRAIGHT_FLUSH {
        @Override
        public String getName() {
            return "Straight Flush";
        }
    },
    FOUR_OF_A_KIND {
        @Override
        public String getName() {
            return "Four Of A Kind";
        }
    },
    FULL_HOUSE {
        @Override
        public String getName() {
            return "Full House";
        }
    },
    FLUSH {
        @Override
        public String getName() {
            return "Flush";
        }
    },
    STRAIGHT {
        @Override
        public String getName() {
            return "Straight";
        }
    },
    THREE_OF_A_KIND {
        @Override
        public String getName() {
            return "Three Of A Kind";
        }
    },
    TWO_PAIR {
        @Override
        public String getName() {
            return "Two Pair";
        }
    },
    JACKS_OR_BETTER {
        @Override
        public String getName() {
            return "Jacks Or Better";
        }
    },
    NO_COMBINATION {
        @Override
        public String getName() {
            return "No Combination";
        }
    };

    public abstract String getName();
}
