package bt.edu.gcit.userservice.dao;

import bt.edu.gcit.userservice.entity.Counselor;
import bt.edu.gcit.userservice.exception.UserNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CounselorDAOImpl implements CounselorDAO {

    private final EntityManager entityManager;

    @Autowired
    public CounselorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Counselor save(Counselor counselor) {
        return entityManager.merge(counselor);
    }

    @Override
    public Counselor findByEmail(String email) {
        TypedQuery<Counselor> query = entityManager.createQuery(
                "SELECT c FROM Counselor c WHERE c.email = :email", Counselor.class);
        query.setParameter("email", email);
        List<Counselor> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public Counselor findById(Long id) {
        return entityManager.find(Counselor.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Counselor counselor = findById(id);
        if (counselor != null) {
            entityManager.remove(counselor);
        }
    }

    @Override
    public void updateCounselorStatus(Long id, boolean status) {
        Counselor counselor = entityManager.find(Counselor.class, id);
        if (counselor == null) {
            throw new UserNotFoundException("Counselor not found with id " + id);
        }
        counselor.setStatus(status);
        entityManager.merge(counselor);
    }

    @Override
    public List<Counselor> getAllCounselors() {
        TypedQuery<Counselor> query = entityManager.createQuery(
                "SELECT c FROM Counselor c", Counselor.class);
        return query.getResultList();
    }
}
