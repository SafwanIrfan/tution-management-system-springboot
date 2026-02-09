package com.safwan.tutionmanagement.repo;

import com.safwan.tutionmanagement.modal.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Long> {
}
