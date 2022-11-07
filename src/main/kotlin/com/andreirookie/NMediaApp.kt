package com.andreirookie

import com.andreirookie.dto.Attachment
import com.andreirookie.dto.Post
import com.andreirookie.enumeration.AttachmentType
import com.andreirookie.service.PostService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class NMediaApp {
    @Bean
    fun runner(service: PostService) = CommandLineRunner {
        with(service) {
            save(
                Post(
                    id = 0,
                    author = "Netology",
                    authorAvatar = "netology.jpg",
                    content = "Привет, это новая Нетология!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                    attachment = Attachment(
                        url = "netology.jpg",
                        description = null,
                        type = AttachmentType.IMAGE
                    )
                )
            )
            save(
                Post(
                    id = 0,
                    author = "Сбер",
                    authorAvatar = "sber.jpg",
                    content = "Привет, это новый Сбер!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                )
            )
            save(
                Post(
                    id = 0,
                    author = "Тинькофф",
                    authorAvatar = "tcs.jpg",
                    content = "Нам и так норм!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                )
            )
            save(
                Post(
                    id = 0,
                    author = "Netology",
                    authorAvatar = "netology.jpg",
                    content = "Подкасты любят за возможность проводить время с пользой и слушать познавательные лекции или беседы во время прогулок или домашних дел. Интересно, что запустить свой подкаст и обсуждать интересные темы может любой.",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                    attachment = Attachment(
                        url = "podcast.jpg",
                        description = "Как запустить свой подкаст: подборка статей",
                        type = AttachmentType.IMAGE,
                    ),
                )
            )
            save(
                Post(
                    id = 0,
                    author = "Сбер",
                    authorAvatar = "sber.jpg",
                    content = "Появился новый способ мошенничества \uD83D\uDE21 Злоумышленники звонят от имени банка и говорят, что для клиента выпущена новая, особо защищённая карта, которую можно добавить в приложение Кошелёк на смартфоне. Под диктовку мошенника человек привязывает к Кошельку его карту, причём указывает своё имя. Если карту пополнить, деньги уйдут мошеннику.\n\nДело в том, что в Кошелёк можно добавить любую, даже чужую карту, а имя поставить какое угодно. Но чужая банковская карта не будет отображаться, например, в СберБанк Онлайн.",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                    attachment = Attachment(
                        url = "sbercard.jpg",
                        description = "Предлагают новую карту? Проверьте, не мошенничество ли это!",
                        type = AttachmentType.IMAGE,
                    ),
                )
            )
        }
    }
}

fun main(args: Array<String>) {
    runApplication<NMediaApp>(*args)
}
