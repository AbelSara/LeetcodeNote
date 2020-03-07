package BFS;

import java.util.*;

/**
 * @author Honghan Zhu
 * @leetcode 210
 * @grade medium
 */
public class CourseSchedulePlus {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] before = new int[numCourses];
        Map<Integer, Set<Integer>> after = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int curCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            before[curCourse] += 1;
            if (!after.containsKey(preCourse))
                after.put(preCourse, new HashSet<>());
            after.get(preCourse).add(curCourse);
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < before.length; i++)
            if (before[i] == 0)
                queue.add(i);
        while (!queue.isEmpty()) {
            int course = queue.poll();
            list.add(course);
            Set<Integer> afterCourses = after.get(course);
            if (afterCourses == null)
                continue;
            afterCourses.forEach(i -> {
                before[i] -= 1;
                if (before[i] == 0)
                    queue.add(i);
            });
            after.remove(course);
        }
        if (list.size() < numCourses)
            return new int[0];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            res[i] = list.get(i);

        return res;
    }
}
