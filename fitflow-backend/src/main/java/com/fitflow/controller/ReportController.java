package com.fitflow.controller;

import com.fitflow.model.dto.AddCommentRequest;
import com.fitflow.model.projection.CommentResponse;
import com.fitflow.model.projection.ReportResponse;
import com.fitflow.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    @Operation(summary = "Get all reports")
    public ResponseEntity<List<ReportResponse>> getReports() {
        return ResponseEntity.ok(reportService.findAllReports());
    }

    @GetMapping("/{id}/comments")
    @Operation(summary = "Get comments for a report")
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.findAllComments(id));
    }

    @PostMapping("/{id}/comments")
    @Operation(summary = "Add comment to a report")
    public ResponseEntity<CommentResponse> addCommentToReport(@PathVariable Long id, @RequestBody AddCommentRequest addCommentRequest) {
        return ResponseEntity.ok(reportService.addCommentToReport(id, addCommentRequest));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get report by id")
    public ResponseEntity<ReportResponse> getReportById(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.findReportById(id));
    }
}
