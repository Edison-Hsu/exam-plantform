package exam.courseContext.domain.model.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CourseTest {

    @Test
    void should_create_course_ok() {
        CourseId id = new CourseId("course-id-1");
        String vlink = "https://vlink";
        Course.Examination examination =
                new Course.Examination("exam-id", "exam-name", "exam-desc");

        Course course = Course.create(id, vlink, examination);

        assertNotNull(course);
        assertEquals(course.getCourseStatus(), CourseStatus.CREATED);
    }

    @Test
    void should_status_published_when_publish_course() {
        CourseId id = new CourseId("course-id-1");
        String vlink = "https://vlink";
        Course.Examination examination =
                new Course.Examination("exam-id", "exam-name", "exam-desc");

        Course course = Course.create(id, vlink, examination);
        course.publish();

        assertNotNull(course);
        assertEquals(course.getCourseStatus(), CourseStatus.PUBLISHED);
    }

    @Test
    void should_update_video_link_ok () {
        CourseId id = new CourseId("course-id-1");
        String vlink = "https://vlink";
        Course.Examination examination =
                new Course.Examination("exam-id", "exam-name", "exam-desc");

        final Course course = Course.create(id, vlink, examination);
        course.update("https://vlink-2");

        assertNotNull(course);
        assertEquals(course.getVideoLink(), "https://vlink-2");
    }
}
