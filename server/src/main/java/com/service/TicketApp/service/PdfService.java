package com.service.TicketApp.service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BarcodeQRCode;
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
public class PdfService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;
    private Font boldFont=new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

    public ByteArrayInputStream generateTicket(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);

        if (booking == null) {
            return null;
        }

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph title = new Paragraph("Bilet", boldFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Numer biletu: " + booking.getId()));
            document.add(new Paragraph("ID użytkownika: " + booking.getUser().getId()));
            document.add(new Paragraph("Suma: " + booking.getPrice()));


            String qrContent = "Bilet ID: " + booking.getId() + "\nID użytkownika: " + booking.getUser().getId();
            BarcodeQRCode qrCode = new BarcodeQRCode(qrContent, 100, 100, null);
            Image qrImage = qrCode.getImage();
            qrImage.setAlignment(Element.ALIGN_CENTER);
            document.add(qrImage);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    public List<Booking> getUserBookings(Long userId) {
        Users user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return null;
        }

        return bookingRepository.findAllByUser(user);
    }
}
