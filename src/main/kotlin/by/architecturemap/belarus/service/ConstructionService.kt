package by.architecturemap.belarus.service

import by.architecturemap.belarus.dto.ConstructionDTO
import by.architecturemap.belarus.dto.ConstructionSearchingDTO
import by.architecturemap.belarus.entity.Construction

interface ConstructionService {

    fun create(construction: Construction): Construction
    fun findAll(): List<Construction>
    fun find(id: Int): Construction

    /**
     * Using for finding Constructions in Elasticsearch
     */
    fun find(constructionSearchingDTO: ConstructionSearchingDTO): List<Construction>

    fun update(id: Int, updatedConstruction: Construction): Construction
    fun patchUpdate(id: Int, updatedConstruction: ConstructionDTO): Construction
    fun delete(id: Int)
}
