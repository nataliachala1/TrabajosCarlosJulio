package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.service.GenericService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación genérica abstracta para servicios CRUD.
 * Las clases hijas deben implementar los métodos de mapeo.
 *
 * @param <Entity>       Entidad JPA
 * @param <RequestDTO>   DTO para crear/actualizar
 * @param <ResponseDTO>  DTO para respuestas
 * @param <ID>           Tipo del identificador
 */
@Transactional
public abstract class GenericServiceImpl<Entity, RequestDTO, ResponseDTO, ID>
        implements GenericService<RequestDTO, ResponseDTO, ID> {

    /**
     * Repositorio específico de cada entidad.
     */
    protected abstract JpaRepository<Entity, ID> getRepository();

    /**
     * Mapea RequestDTO → Entity.
     */
    protected abstract Entity mapToEntity(RequestDTO dto);

    /**
     * Mapea Entity → ResponseDTO.
     */
    protected abstract ResponseDTO mapToResponse(Entity entity);

    /**
     * Actualiza los datos de la entidad desde el DTO.
     */
    protected abstract void updateEntity(Entity entity, RequestDTO dto);

    /**
     * Nombre de la entidad (solo para mensajes de error).
     */
    protected abstract String getEntityName();

    @Override
    @Transactional(readOnly = true)
    public List<ResponseDTO> findAll() {
        return getRepository().findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDTO findById(ID id) {
        Entity entity = getRepository().findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(getEntityName() + " no encontrado con ID: " + id)
                );
        return mapToResponse(entity);
    }

    @Override
    public ResponseDTO create(RequestDTO dto) {
        Entity entity = mapToEntity(dto);
        Entity saved = getRepository().save(entity);
        return mapToResponse(saved);
    }

    @Override
    public ResponseDTO update(ID id, RequestDTO dto) {
        Entity entity = getRepository().findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(getEntityName() + " no encontrado con ID: " + id)
                );

        updateEntity(entity, dto);

        Entity updated = getRepository().save(entity);
        return mapToResponse(updated);
    }

    @Override
    public void delete(ID id) {
        if (!getRepository().existsById(id)) {
            throw new EntityNotFoundException(
                    getEntityName() + " no encontrado con ID: " + id);
        }
        getRepository().deleteById(id);
    }
}
