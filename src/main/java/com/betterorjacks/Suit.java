package com.betterorjacks;

public enum Suit {
    CLUBS {
        @Override
        public String getName() {
            return "Clubs";
        }
    },
    DIAMONDS {
        @Override
        public String getName() {
            return "Diamonds";
        }
    },
    HEARTS {
        @Override
        public String getName() {
            return "Hearts";
        }
    },
    SPADES {
        @Override
        public String getName() {
            return "Spades";
        }
    };

    public abstract String getName();
}
