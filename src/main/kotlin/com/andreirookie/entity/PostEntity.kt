package com.andreirookie.entity

import com.andreirookie.dto.Post
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    var author: String,
    var content: String,
    var published: Long,
    var likedByMe: Boolean,
    var likes: Int = 0,
) {

    fun toDto() = Post(id, author, content, published, likedByMe, likes)

    companion object {
        fun fromDto(dto: Post) = PostEntity(dto.id, dto.author, dto.content,dto.published, dto.likedByMe, dto.likes)
    }
}