package com.soptkathonserverandroid2.domain.recommend.service;

import com.soptkathonserverandroid2.domain.recommend.repository.RecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class RecommendService {

    private final RecommendRepository recommendRepository;

    @Transactional
    public
}
