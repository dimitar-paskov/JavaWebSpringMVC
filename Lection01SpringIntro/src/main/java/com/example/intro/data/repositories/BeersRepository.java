/**
 * @author dimitar
 *
 */
package com.example.intro.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intro.data.models.Beer;

public interface BeersRepository extends JpaRepository<Beer, Long> {

}
