package com.andreirookie.service

import com.andreirookie.dto.Post
import com.andreirookie.entity.PostEntity
import org.springframework.stereotype.Service
import org.springframework.data.domain.Sort
import com.andreirookie.exception.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import com.andreirookie.repository.PostRepository

import java.time.OffsetDateTime

@Service
class PostService(private val repository: PostRepository) {
    fun getAll(): List<Post> = repository
        .findAll(Sort.by(Sort.Direction.DESC, "id"))
        .map { it.toDto()}

    fun getById(id: Long): Post = repository
        .findById(id)
        .map {it.toDto()}
        .orElseThrow(::NotFoundException)

    fun save(dto: Post): Post = repository
        .findById(dto.id)
        .orElse(
            PostEntity.fromDto(
                dto.copy(
                    likes = 0,
                    likedByMe = false,
                    published = OffsetDateTime.now().toEpochSecond()
                )
            )
        )
        .let {
            if (it.id != 0L) {
                it.content = dto.content
            }
            repository.save(it)
            it
        }.toDto()

    fun removeById(id: Long) {
        repository.findByIdOrNull(id)
            ?.also(repository::delete)
    }
}