package com.andreirookie.controller

import com.andreirookie.dto.Post
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.andreirookie.service.PostService


// описание доступных запросов

@RestController
@RequestMapping("/api/posts", "/api/slow/posts")
class PostController(private val service: PostService) {

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = service.getById(id)

    @PostMapping
    fun save(@RequestBody dto: Post) = service.save(dto)


    @DeleteMapping("/{id}")
    fun removeById(@PathVariable id: Long)  =service.removeById(id)

    @PostMapping("/{id}/likes")
    fun likeById(@PathVariable id: Long) = service.likeById(id)

    @DeleteMapping("/{id}/likes")
    fun dislikeById(@PathVariable id: Long) = service.dislikeById(id)
}