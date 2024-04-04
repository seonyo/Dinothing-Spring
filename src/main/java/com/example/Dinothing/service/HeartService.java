package com.example.Dinothing.service;

import com.example.Dinothing.dto.HeartDto;
import com.example.Dinothing.entity.HeartEntity;
import com.example.Dinothing.exception.HeartDuplicateException;
import com.example.Dinothing.exception.IdeaNotFoundException;
import com.example.Dinothing.exception.error.ErrorCode;
import com.example.Dinothing.repository.HeartRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class HeartService {
    private final HeartRepository heartRepository;

    public HeartEntity createHeart(HeartDto request){
        Long ideaId = request.getIdeaId().getId();
        Long userId = request.getUserId().getId();

        Optional<HeartEntity> optionalHeart = heartRepository.findByUserIdAndIdeaId(userId, ideaId);

        if(optionalHeart.isPresent()) {
            throw new HeartDuplicateException("Heart Duplicate", ErrorCode.HEART_DUPLICATION);
        }

        return heartRepository.save(request.toEntity());
    }

}