package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {

    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("imagee 1", 100),
                new Attachment("image 2", 34),
                new Attachment("imageen 3", 13)
        );
        Comparator<Attachment> comparator = Comparator.comparingInt(Attachment::getSize);
        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator<Attachment> comparator1 = Comparator.comparing(Attachment::getName);
        attachments.sort(comparator1);
        System.out.println(attachments);

        Comparator<Attachment> comp = ((o1, o2) -> Integer.compare(o2.getName().length(), o1.getName().length()));
        attachments.sort(comp);
        System.out.println(attachments);
    }
}