package com.fitflow.controller;

import com.fitflow.model.dto.AddMentorshipRequest;
import com.fitflow.model.trainer.Mentorship;
import com.fitflow.model.projection.MentorshipResponse;
import com.fitflow.service.MentorshipService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mentorships")
public class MentorshipController {

    private final MentorshipService mentorshipService;

    @GetMapping
    @Operation(summary = "Get all mentorships")
    public ResponseEntity<List<MentorshipResponse>> getMentorships() {
        return ResponseEntity.ok(mentorshipService.findAllMentorships());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get mentorship by id")
    public ResponseEntity<MentorshipResponse> getMentorshipById(@PathVariable Long id) {
        return ResponseEntity.ok(mentorshipService.findMentorshipById(id));
    }

    @PostMapping
    @Operation(summary = "Create mentorship")
    public ResponseEntity<MentorshipResponse> createMentorship(@RequestBody AddMentorshipRequest mentorship) {
        return ResponseEntity.ok(mentorshipService.saveMentorship(mentorship));
    }

    @PutMapping
    @Operation(summary = "Update mentorship")
    public ResponseEntity<MentorshipResponse> updateMentorship(Mentorship mentorship) {
        return ResponseEntity.ok(mentorshipService.updateMentorship(mentorship));
    }
}
