package com.andreirookie.repository

import com.andreirookie.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository


interface PostRepository: JpaRepository<PostEntity, Long>
                                    // , Long> - Primary key