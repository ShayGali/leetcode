package algorithms.medium.my_calendar_I_729;

import java.util.ArrayList;


class MyCalendar {
    ArrayList<Booking> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (bookings.isEmpty()) {
            bookings.add(new Booking(start, end));
            return true;
        }

        int l = 0, r = bookings.size() - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            Booking current = bookings.get(mid);
            if (start >= current.start && start < current.end ||
                    end > current.start && end <= current.end ||
                    start < current.start && end >= current.end) {
                return false;
            } else if (current.end <= start) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        bookings.add(l, new Booking(start, end));
        return true;
    }

    private static class Booking {
        int start;
        int end;

        public Booking(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

        /*
            ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
            [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
            [null,true,true,false,false,true,false,true,true,true,false]
         */
//    public static void main(String[] args) {
//        MyCalendar myCalendar = new MyCalendar();
//        myCalendar.book(47, 50); // +
//        myCalendar.book(33, 41); // +
//        myCalendar.book(39, 45); // -
//        myCalendar.book(33, 42); // -
//        myCalendar.book(25, 32); // +
//        myCalendar.book(26, 35); // -
//        myCalendar.book(19, 25); // +
//        myCalendar.book(3, 8); // +
//        myCalendar.book(8, 13); // +
//        myCalendar.book(18, 27); // -
//
//    }

    public static void main(String[] args) {
        /*
            ["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
            [[],[20,29],[13,22],[44,50],[1,7],[2,10],[14,20],[19,25],[36,42],[45,50],[47,50],[39,45],[44,50],[16,25],[45,50],[45,50],[12,20],[21,29],[11,20],[12,17],[34,40],[10,18],[38,44],[23,32],[38,44],[15,20],[27,33],[34,42],[44,50],[35,40],[24,31]]
            [null,true,false,true,true,false,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]

           [36,42],[45,50],[47,50],[39,45],[44,50],[16,25],[45,50],[45,50],[12,20],[21,29],[11,20],[12,17],[34,40],[10,18],[38,44],[23,32],[38,44],[15,20],[27,33],[34,42],[44,50],[35,40],[24,31]]
           true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false]
        */
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(20, 29); // T
        myCalendar.book(13, 22); // F
        myCalendar.book(44, 50); // T
        myCalendar.book(1, 7);   // T
        myCalendar.book(2, 10);  // F
        myCalendar.book(14, 20);  // T
        myCalendar.book(19, 25);  // F
        myCalendar.book(36, 42);  // T
    }
}
