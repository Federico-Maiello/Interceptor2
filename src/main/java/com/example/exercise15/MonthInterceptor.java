package com.example.exercise15;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    private List<Month> months = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumber = request.getHeader("monthNumber");

        if (monthNumber == null || monthNumber.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Month number is required");
            return false;
        }

        Optional<Month> foundMonth = months.stream()
                .filter(m -> m.getMonthNumber() == Integer.parseInt(monthNumber))
                .findFirst();

        if (foundMonth.isPresent()) {
            request.setAttribute("month", foundMonth.get());
        } else {
            Month emptyMonth = new Month();
            emptyMonth.setEnglishName("nope");
            emptyMonth.setItalianName("nope");
            emptyMonth.setGermanName("nope");
            request.setAttribute("month", emptyMonth);
        }

        return true;
    }
}