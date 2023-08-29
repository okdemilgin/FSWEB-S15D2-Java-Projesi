package com.workintech.company.model;

import java.util.*;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTask;

//    public TaskData() {
//        annsTasks = new HashSet<>();
//    }

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTask) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTask = unassignedTask;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }
    public Set<Task> getUnassignedTask() {
        return unassignedTask;
    }

    public Set<Task> getTasks(String taskOwner){
        if(taskOwner.equals("ann")){
            return annsTasks;
        }
        if(taskOwner.equals("bob")){
            return bobsTasks;
        }
        if(taskOwner.equals("carol")){
            return carolsTasks;
        }
        if(taskOwner.equals("all")){
            List<Set<Task>> taskList = new ArrayList<>();
            taskList.add(annsTasks);
            taskList.add(carolsTasks);
            taskList.add(bobsTasks);
            return getUnion(taskList);
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(List<Set<Task>> taskList){
        Set<Task> totals = new LinkedHashSet<>();
        for(Set<Task> tasks: taskList){
            totals.addAll(tasks);
        }
        return totals;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
        Set<Task> intersection = new HashSet<>(first);
        intersection.retainAll(second);
        //intersection.retainAll(third);
        return intersection;
    }

    public Set<Task> getDifference(Set<Task> first, Set<Task> second){
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second);
        return differences;
    }

    public Set<Task> getUnion(Set<Task>... taskList){
        return null;
    }

}