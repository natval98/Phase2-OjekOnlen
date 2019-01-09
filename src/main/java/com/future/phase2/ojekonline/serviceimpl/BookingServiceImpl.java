package com.future.phase2.ojekonline.serviceimpl;

import com.future.phase2.ojekonline.entity.Booking;
import com.future.phase2.ojekonline.entity.Driver;
import com.future.phase2.ojekonline.entity.Member;
import com.future.phase2.ojekonline.entity.Payment;
import com.future.phase2.ojekonline.repository.BookingRepository;
import com.future.phase2.ojekonline.repository.DriverRepository;
import com.future.phase2.ojekonline.repository.MemberRepository;
import com.future.phase2.ojekonline.repository.PaymentRepository;
import com.future.phase2.ojekonline.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @Override
    public Booking createBooking(Booking booking, Long memberId, Long driverId, Integer paymentId) throws ParseException {
        Booking newBooking = new Booking();
        Driver driver = driverRepository.findDriverById(driverId);
        Member member = memberRepository.findOne(memberId);
        Payment payment = paymentRepository.findOne(paymentId);

//        https://www.mkyong.com/java/how-to-compare-dates-in-java/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateNow = new Date();
//        Date dateBooking = booking.getTime();
        String dateNowString = new Date().toString();
        String dateBookingString = booking.getTime().toString();
        Date dateNow = sdf.parse(dateNowString);
        Date dateBooking = sdf.parse(dateBookingString);

        newBooking.setId(UUID.randomUUID().toString());
        newBooking.setAddressFrom(booking.getAddressFrom());
        newBooking.setAddressTo(booking.getAddressTo());
        newBooking.setAmount(booking.getAmount());

        if (dateNow.before(dateBooking)) {
            newBooking.setBookingType(Booking.bookingType.REQUEST);
            newBooking.setTime(dateNow);
        }
        else {
            newBooking.setBookingType(Booking.bookingType.BOOKED);
            newBooking.setTime(dateBooking);
        }
        newBooking.setDriver(driver);
        newBooking.setMember(member);
        newBooking.setPayment(payment);
        return bookingRepository.save(newBooking);
    }

    @Override
    public Booking cancelBooking(String id){
        Booking existBooking = bookingRepository.findOne(id);
        if (existBooking != null){
            if (existBooking.getBookingType().toString().equals("REQUEST") || existBooking.getBookingType().toString().equals("BOOKED")){
                existBooking.setBookingType(Booking.bookingType.CANCELLED);
                return bookingRepository.save(existBooking);
            }
            else throw new RuntimeException("Cancel booking not allowed!");

        }
        else throw new RuntimeException("Booking not found!");
    }

    @Override
    public List<Booking> listMemberBookingHistory(Long memberId){
        Member member = memberRepository.findOne(memberId);
        if (member != null) {
            return bookingRepository.findBookingsByMember(member);
        }
        else throw new RuntimeException("Member & history not found!");
    }
}
