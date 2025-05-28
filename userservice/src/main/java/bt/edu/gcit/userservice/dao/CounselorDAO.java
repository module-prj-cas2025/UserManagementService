package bt.edu.gcit.userservice.dao;

import bt.edu.gcit.userservice.entity.Counselor;
import java.util.List;

public interface CounselorDAO {
    Counselor save(Counselor counselor);
    Counselor findByEmail(String email);
    Counselor findById(Long id);
    void deleteById(Long id);
    void updateCounselorStatus(Long id, boolean status);
    List<Counselor> getAllCounselors();
}