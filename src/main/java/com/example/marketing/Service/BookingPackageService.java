package com.example.marketing.Service;

import com.example.marketing.DTOs.BookingPackageDTO;
import com.example.marketing.Model.BookingPackage;
import com.example.marketing.Repostiroy.BookingPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class BookingPackageService {

    @Autowired
    private BookingPackageRepository bookingPackageRepository;

    public List<BookingPackage> getAllBookingPackages() {
        return bookingPackageRepository.findAll();
    }



    public Optional<BookingPackage> getBookingPackageById(Integer PackageId) {
        return bookingPackageRepository.findById(PackageId);
    }

    public void addBookingPackage(BookingPackageDTO bookingPackageDTO) {

        BookingPackage bookingPackage = new BookingPackage();
        bookingPackage.setTotal(bookingPackageDTO.getTotal());
        bookingPackage.setBookingDate(LocalDate.now());
        bookingPackage.setBookingTotalPrice(bookingPackageDTO.getBookingTotalPrice());
        bookingPackage.setBookingStatus(bookingPackageDTO.getBookingStatus());

         bookingPackageRepository.save(bookingPackage);
    }

    public BookingPackage updateBookingPackage(int id, BookingPackageDTO bookingPackageDTO) {
        BookingPackage bookingPackage = bookingPackageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingPackage not found"));

        bookingPackage.setTotal(bookingPackageDTO.getTotal());
        bookingPackage.setBookingDate(bookingPackageDTO.getBookingDate());
        bookingPackage.setBookingTotalPrice(bookingPackageDTO.getBookingTotalPrice());
        bookingPackage.setBookingStatus(bookingPackageDTO.getBookingStatus());
        // Update other fields like company, influencer, packageEntity

        return bookingPackageRepository.save(bookingPackage);
    }

    public void deleteBookingPackage(int id) {
        bookingPackageRepository.deleteById(id);
    }
}
