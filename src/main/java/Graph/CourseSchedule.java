package Graph;

import java.util.*;

/**
 * @Author Honghan Zhu
 * @leetcode 207
 * @grade medium
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> beforeCourseMap = new HashMap<>();
        Map<Integer, Set<Integer>> afterCourseMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            if (!beforeCourseMap.containsKey(course))
                beforeCourseMap.put(course, new HashSet<>());
            if(!afterCourseMap.containsKey(preCourse))
                afterCourseMap.put(preCourse,new HashSet<>());
            Set<Integer> beforeCourseList = beforeCourseMap.get(course);
            beforeCourseList.add(preCourse);
            Set<Integer> afterCourseList = afterCourseMap.get(preCourse);
            afterCourseList.add(course);
            set.add(preCourse);
        }
        beforeCourseMap.entrySet().stream().forEach(entry -> set.remove(entry.getKey()));
        LinkedList<Integer> noPreCourse = new LinkedList<>(set);
        while (!noPreCourse.isEmpty()) {
            int preCourse = noPreCourse.removeFirst();
            Set<Integer> afterCourseList = afterCourseMap.get(preCourse);
            if(afterCourseList == null || afterCourseList.isEmpty())
                continue;
            for(Integer aferCourse : afterCourseList){
                Set<Integer> beforeCouseList = beforeCourseMap.get(aferCourse);
                beforeCouseList.remove(preCourse);
                if(beforeCouseList.isEmpty()){
                    noPreCourse.add(aferCourse);
                    beforeCourseMap.remove(aferCourse);
                }
            }
        }
        return beforeCourseMap.isEmpty();
    }
}
