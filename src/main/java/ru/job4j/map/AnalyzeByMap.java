package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        int number = 0;
        for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                totalScore += sub.getScore();
            }
            number += pupil.subjects().size();
        }
        return (double) totalScore / number;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        int totalScore;
        for (Pupil pupil : pupils) {
            totalScore = 0;
            for (Subject sub : pupil.subjects()) {
                totalScore += sub.getScore();
            }
            result.add(new Label(pupil.name(),
                    (double) totalScore / pupil.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            pupil.subjects().forEach(subject ->
                map.merge(subject.getName(), subject.getScore(), Integer::sum));
        }
        map.forEach((k, v) ->
                result.add(new Label(k, (double) v / pupils.size())));
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        int totalScore;
        for (Pupil pupil : pupils) {
            totalScore = 0;
            for (Subject sub : pupil.subjects()) {
                totalScore += sub.getScore();
            }
            result.add(new Label(pupil.name(), totalScore));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            pupil.subjects().forEach(subject ->
                 map.merge(subject.getName(), subject.getScore(), Integer::sum));
        }
        map.forEach((k, v) -> result.add(new Label(k, v)));
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
