package com.betterorjacks;

public enum Rank {
    ACE {
        @Override
        public String getName() {
            return "Ace";
        }
    },
    TWO {
        @Override
        public String getName() {
            return "Two";
        }
    },
    THREE {
        @Override
        public String getName() {
            return "Three";
        }
    },
    FOUR {
        @Override
        public String getName() {
            return "Four";
        }
    },
    FIVE {
        @Override
        public String getName() {
            return "Five";
        }
    },
    SIX {
        @Override
        public String getName() {
            return "Six";
        }
    },
    SEVEN {
        @Override
        public String getName() {
            return "Seven";
        }
    },
    EIGHT {
        @Override
        public String getName() {
            return "Eight";
        }
    },
    NINE {
        @Override
        public String getName() {
            return "Nine";
        }
    },
    TEN {
        @Override
        public String getName() {
            return "Ten";
        }
    },
    JACK {
        @Override
        public String getName() {
            return "Jack";
        }
    },
    QUEEN {
        @Override
        public String getName() {
            return "Queen";
        }
    },
    KING {
        @Override
        public String getName() {
            return "King";
        }
    };

    public abstract String getName();

}
