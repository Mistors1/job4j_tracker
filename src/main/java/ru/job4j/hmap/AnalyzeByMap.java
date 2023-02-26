package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        double subjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject score : pupil.subjects()) {
                rsl += score.score();
                subjects++;
            }
        }
        rsl = rsl / subjects;
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double average = 0;
            double subjects = 0;
            for (Subject score : pupil.subjects()) {
                average += score.score();
                subjects++;
            }
            average = average / subjects;
            labels.add(new Label(pupil.name(), average));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> avSubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int scope = avSubject.getOrDefault(subject.name(), 0);
                avSubject.put(subject.name(), scope + subject.score());
            }
        }
        for (String subject : avSubject.keySet()) {
            labels.add(new Label(subject, avSubject.get(subject) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new LinkedList<>();
        for (Pupil pupil : pupils) {
            double average = 0;
            for (Subject score : pupil.subjects()) {
                average += score.score();
            }
            labels.add(new Label(pupil.name(), average));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> avSubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int scope = avSubject.getOrDefault(subject.name(), 0);
                avSubject.put(subject.name(), scope + subject.score());
            }
        }
        for (String subject : avSubject.keySet()) {
            labels.add(new Label(subject, avSubject.get(subject)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}