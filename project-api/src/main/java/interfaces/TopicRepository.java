/**
 * TopicRepository interface using CrudRepository
 */
package interfaces;

import org.springframework.data.repository.CrudRepository;

import objects.TopicObject;

public interface TopicRepository extends CrudRepository<TopicObject, String> {

}
