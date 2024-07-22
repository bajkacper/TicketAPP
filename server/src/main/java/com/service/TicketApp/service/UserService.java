package com.service.TicketApp.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.service.TicketApp.entity.Booking;
import com.service.TicketApp.entity.Users;
import com.service.TicketApp.repository.BookingRepository;
import com.service.TicketApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;
    public List<Booking> getTickets(Long id){
        Users user = userRepository.findById(id).orElse(null);
        return bookingRepository.findAllByUser(user);
    }
    public Users getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Users updateUser(Long id, Users user) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUserName(user.getUserName());
        existingUser.setEmail(user.getEmail());
        existingUser.setLastName(user.getLastName());
        existingUser.setPassword(user.getPassword());
        existingUser.setUserType(user.getUserType());
        existingUser.setActivated(user.getActivated());
        existingUser.setVerification(user.getVerification());
        return userRepository.save(existingUser);
    }

    public ByteArrayInputStream generateTicketPdf(Long bookingId) throws DocumentException {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

        Paragraph title = new Paragraph("Ticket", boldFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph("Booking ID: " + booking.getId()));
        document.add(new Paragraph("User ID: " + booking.getUser().getId()));
        document.add(new Paragraph("Price: " + booking.getPrice()));

        document.close();

        return new ByteArrayInputStream(out.toByteArray());
    }

}
