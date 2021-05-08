package CodeTogether.hellospring.repository;

import CodeTogether.hellospring.domain.Subject;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class JdbcSubjectRepository implements SubjectRepository {

    private final DataSource dataSource;
    public JdbcSubjectRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Subject save(Subject subject) {
        String sql = "insert into subject (subject_name, subject_pref, subject_desc, subject_circle) values(?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = getConnection();
            pstmt = conn.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, subject.getSubject_name());
            pstmt.setString(2, subject.getSubject_desc());
            pstmt.setString(3, subject.getSubject_pref());
            pstmt.setLong(4, subject.getSubject_circle());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                subject.setSubject_id(rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return subject;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Subject> findById(Long id) {
        String sql = "select * from subject where subject_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Subject subject = new Subject();
                subject.setSubject_id(rs.getLong("subject_id"));
                subject.setSubject_name(rs.getString("subject_name"));
                subject.setSubject_desc(rs.getString("subject_desc"));
                subject.setSubject_pref(rs.getString("subject_pref"));
                subject.setSubject_circle(rs.getLong("subject_circle"));
                return Optional.of(subject);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }
    @Override
    public Optional<Subject> findBySubjectName(String subject_name) {
        String sql = "select * from subject where subject_name = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, subject_name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                Subject subject = new Subject();
                subject.setSubject_id(rs.getLong("subject_id"));
                subject.setSubject_name(rs.getString("subject_name"));
                subject.setSubject_desc(rs.getString("subject_desc"));
                subject.setSubject_pref(rs.getString("subject_pref"));
                subject.setSubject_circle(rs.getLong("subject_circle"));
                return Optional.of(subject);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Subject> findByCircle(Long subject_circle) {
        String sql = "select * from subject where subject_circle = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, subject_circle);
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(rs.next()) {
                Subject subject = new Subject();
                subject.setSubject_id(rs.getLong("subject_id"));
                subject.setSubject_name(rs.getString("subject_name"));
                subject.setSubject_desc(rs.getString("subject_desc"));
                subject.setSubject_pref(rs.getString("subject_pref"));
                subject.setSubject_circle(rs.getLong("subject_circle"));
                subjects.add(subject);
            }
            return subjects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Subject> findAll() {
        String sql = "select * from subject";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<Subject> subjects = new ArrayList<>();
            while(rs.next()) {
                Subject subject = new Subject();
                subject.setSubject_id(rs.getLong("subject_id"));
                subject.setSubject_name(rs.getString("subject_name"));
                subject.setSubject_desc(rs.getString("subject_desc"));
                subject.setSubject_pref(rs.getString("subject_pref"));
                subject.setSubject_circle(rs.getLong("subject_circle"));
                subjects.add(subject);
            }
            return subjects;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
