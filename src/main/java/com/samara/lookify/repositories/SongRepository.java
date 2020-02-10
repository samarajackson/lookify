package com.samara.lookify.repositories;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samara.lookify.models.Song;


@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findByArtistContainingIgnoreCaseOrTitleContainingIgnoreCase(String search1,String search2);
	List<Song> findTop10ByOrderByRatingDesc();
}
