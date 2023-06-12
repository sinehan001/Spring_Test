package com.sinehan.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query(nativeQuery = true,value = "SELECT a.id,a.lane1,a.lane2,a.state,a.zip FROM address AS a JOIN employee AS e ON e.id=a.empid WHERE a.empid=1")
    Address findAddressByEmployeeId(@Param("empid") int id);
}
