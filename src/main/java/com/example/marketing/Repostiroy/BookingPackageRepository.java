package com.example.marketing.Repostiroy;

import com.example.marketing.Model.BookingPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingPackageRepository extends JpaRepository<BookingPackage, Integer> {




}
