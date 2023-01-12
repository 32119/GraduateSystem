package coursedesign.db.dao;

import java.util.List;

public interface courseDAO {
    void addCourse(course c);
    void updateCourse(course c);
    void deleteCourse(String course_id);
    course getCourseById(String course_id);
    List<course> getCourse();
}
