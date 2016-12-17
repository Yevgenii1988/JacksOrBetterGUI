package com.betterorjacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    ACE {
        @Override
        public String getName() {
            return "Ace";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(ACE, TWO, THREE, FOUR, FIVE));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(TEN, JACK, QUEEN, KING, ACE));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            return straights;
        }
    },
    TWO {
        @Override
        public String getName() {
            return "Two";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(ACE, TWO, THREE, FOUR, FIVE));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(TWO, THREE, FOUR, FIVE, SIX));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            return straights;
        }
    },
    THREE {
        @Override
        public String getName() {
            return "Three";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(ACE, TWO, THREE, FOUR, FIVE));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(TWO, THREE, FOUR, FIVE, SIX));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(THREE, FOUR, FIVE, SIX, SEVEN));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            return straights;
        }
    },
    FOUR {
        @Override
        public String getName() {
            return "Four";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(ACE, TWO, THREE, FOUR, FIVE));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(TWO, THREE, FOUR, FIVE, SIX));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(THREE, FOUR, FIVE, SIX, SEVEN));
            ArrayList<Rank> list4 = new ArrayList<>(Arrays.asList(FOUR, FIVE, SIX, SEVEN, EIGHT));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            straights.add(list4);
            return straights;
        }
    },
    FIVE {
        @Override
        public String getName() {
            return "Five";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(ACE, TWO, THREE, FOUR, FIVE));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(TWO, THREE, FOUR, FIVE, SIX));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(THREE, FOUR, FIVE, SIX, SEVEN));
            ArrayList<Rank> list4 = new ArrayList<>(Arrays.asList(FOUR, FIVE, SIX, SEVEN, EIGHT));
            ArrayList<Rank> list5 = new ArrayList<>(Arrays.asList(FIVE, SIX, SEVEN, EIGHT, NINE));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            straights.add(list4);
            straights.add(list5);
            return straights;
        }
    },
    SIX {
        @Override
        public String getName() {
            return "Six";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(TWO, THREE, FOUR, FIVE, SIX));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(THREE, FOUR, FIVE, SIX, SEVEN));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(FOUR, FIVE, SIX, SEVEN, EIGHT));
            ArrayList<Rank> list4 = new ArrayList<>(Arrays.asList(FIVE, SIX, SEVEN, EIGHT, NINE));
            ArrayList<Rank> list5 = new ArrayList<>(Arrays.asList(SIX, SEVEN, EIGHT, NINE, TEN));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            straights.add(list4);
            straights.add(list5);
            return straights;
        }
    },
    SEVEN {
        @Override
        public String getName() {
            return "Seven";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(THREE, FOUR, FIVE, SIX, SEVEN));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(FOUR, FIVE, SIX, SEVEN, EIGHT));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(FIVE, SIX, SEVEN, EIGHT, NINE));
            ArrayList<Rank> list4 = new ArrayList<>(Arrays.asList(SIX, SEVEN, EIGHT, NINE, TEN));
            ArrayList<Rank> list5 = new ArrayList<>(Arrays.asList(SEVEN, EIGHT, NINE, TEN, JACK));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            straights.add(list4);
            straights.add(list5);
            return straights;
        }
    },
    EIGHT {
        @Override
        public String getName() {
            return "Eight";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(FOUR, FIVE, SIX, SEVEN, EIGHT));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(FIVE, SIX, SEVEN, EIGHT, NINE));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(SIX, SEVEN, EIGHT, NINE, TEN));
            ArrayList<Rank> list4 = new ArrayList<>(Arrays.asList(SEVEN, EIGHT, NINE, TEN, JACK));
            ArrayList<Rank> list5 = new ArrayList<>(Arrays.asList(EIGHT, NINE, TEN, JACK, QUEEN));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            straights.add(list4);
            straights.add(list5);
            return straights;
        }
    },
    NINE {
        @Override
        public String getName() {
            return "Nine";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(FIVE, SIX, SEVEN, EIGHT, NINE));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(SIX, SEVEN, EIGHT, NINE, TEN));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(SEVEN, EIGHT, NINE, TEN, JACK));
            ArrayList<Rank> list4 = new ArrayList<>(Arrays.asList(EIGHT, NINE, TEN, JACK, QUEEN));
            ArrayList<Rank> list5 = new ArrayList<>(Arrays.asList(NINE, TEN, JACK, QUEEN, KING));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            straights.add(list4);
            straights.add(list5);
            return straights;
        }
    },
    TEN {
        @Override
        public String getName() {
            return "Ten";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(SIX, SEVEN, EIGHT, NINE, TEN));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(SEVEN, EIGHT, NINE, TEN, JACK));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(EIGHT, NINE, TEN, JACK, QUEEN));
            ArrayList<Rank> list4 = new ArrayList<>(Arrays.asList(NINE, TEN, JACK, QUEEN, KING));
            ArrayList<Rank> list5 = new ArrayList<>(Arrays.asList(TEN, JACK, QUEEN, KING, ACE));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            straights.add(list4);
            straights.add(list5);
            return straights;
        }
    },
    JACK {
        @Override
        public String getName() {
            return "Jack";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(SEVEN, EIGHT, NINE, TEN, JACK));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(EIGHT, NINE, TEN, JACK, QUEEN));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(NINE, TEN, JACK, QUEEN, KING));
            ArrayList<Rank> list4 = new ArrayList<>(Arrays.asList(TEN, JACK, QUEEN, KING, ACE));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            straights.add(list4);
            return straights;
        }
    },
    QUEEN {
        @Override
        public String getName() {
            return "Queen";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(EIGHT, NINE, TEN, JACK, QUEEN));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(NINE, TEN, JACK, QUEEN, KING));
            ArrayList<Rank> list3 = new ArrayList<>(Arrays.asList(TEN, JACK, QUEEN, KING, ACE));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            straights.add(list3);
            return straights;
        }
    },
    KING {
        @Override
        public String getName() {
            return "King";
        }

        @Override
        public List<List<Rank>> getStraightsList() {
            ArrayList<Rank> list1 = new ArrayList<>(Arrays.asList(NINE, TEN, JACK, QUEEN, KING));
            ArrayList<Rank> list2 = new ArrayList<>(Arrays.asList(TEN, JACK, QUEEN, KING, ACE));
            ArrayList<List<Rank>> straights = new ArrayList<>();
            straights.add(list1);
            straights.add(list2);
            return straights;
        }
    };

    public abstract String getName();

    public abstract List<List<Rank>> getStraightsList();
}
