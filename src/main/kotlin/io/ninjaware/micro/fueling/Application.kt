package io.ninjaware.micro.fueling

import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.Javalin

fun main(args: Array<String>) {


    val app = Javalin.create().apply {
        port(7000)
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start()

    app.routes {

        get("/users") { ctx ->
            // ctx.json(userDao.users)
            ctx.status(200)
        }

        get("/users/:id") { ctx ->
            // ctx.json(userDao.findById(ctx.pathParam("id").toInt())!!)
            ctx.json(ctx.pathParam("id"))
        }

        get("/users/email/:email") { ctx ->
            // ctx.json(userDao.findByEmail(ctx.pathParam("email"))!!)
            ctx.json(ctx.pathParam("email"))
        }

        post("/users") { ctx ->
            // val user = ctx.body<User>()
            // userDao.save(name = user.name, email = user.email)
            ctx.status(201)
        }

        patch("/users/:id") { ctx ->
            // val user = ctx.body<User>()
            // userDao.update(
            //        id = ctx.pathParam("id").toInt(),
            //        user = user
            // )
            ctx.status(204)
        }

        delete("/users/:id") { ctx ->
            // userDao.delete(ctx.pathParam("id").toInt())
            ctx.status(204)
        }

    }

}
