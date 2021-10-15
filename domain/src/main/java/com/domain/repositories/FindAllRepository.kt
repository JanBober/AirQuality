package com.domain.repositories

import com.domain.entities.model.Root
import io.reactivex.Single

interface FindAllRepository {

    fun get(): Single<List<Root>>
}