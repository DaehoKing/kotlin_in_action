package com.pi.big._5_lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    static class Item {
        long price;

        public long getPrice() {
            return price;
        }

        public Item(long price) {
            this.price = price;
        }
    }

    public <T> void postponeComputation2(int delay, Consumer<T> consumer, T arg) {
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumer.accept(arg);
    }

    public static void postponeComputation(int delay, Runnable job) {
        //...
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        job.run();
    }

    public static void main(String[] args) {
        Item item = Stream.of(new Item(1000), new Item(900), new Item(1500), new Item(500))
                .max(Comparator.comparingLong(Item::getPrice)).get();

        System.out.println("Maximum item price : " + item.getPrice());

        var sum = (Sum)(x, y) -> x + y;

//        new Main().postphoneComputation(10, );

        var a = "hi";
        var b = "hi";
        var c = new String("hi");

        System.out.println("a == b : " + (a == b));
        System.out.println("a == c : " + (a == c));
    }
}
