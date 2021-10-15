package com.domain.usecases

import com.domain.entities.model.Root
import com.domain.repositories.FindAllRepository
import io.reactivex.Single

class GetFindAllUseCase(private val findAllRepository: FindAllRepository) {

    fun execute(): Single<List<Root>> {
        return findAllRepository.get()
    }
}