package com.samara.lookify.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.samara.lookify.models.Song;
import com.samara.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;
    
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }
    // returns all the books
    public List<Song> allSongs() {
        return songRepository.findAll();
    }
    // creates a book
    public Song createSong(Song s) {
        return songRepository.save(s);
    }
    // retrieves a book
    public Song findSong(Long id) {
        Optional<Song> optSong = songRepository.findById(id);
        if(optSong.isPresent()) {
            return optSong.get();
        } else {
            return null;
        }
    }
	public Song updateSong(Long id, String title, String artist, Integer rating) {
		// TODO Auto-generated method stub
		Song s = findSong(id);
			if (s !=null) {
				s.setArtist(artist);
				s.setTitle(title);
				s.setRating(rating);
				songRepository.save(s);
			}
		return s;
	}
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	public List<Song> top10(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	public List<Song> search(String search){
		return songRepository.findByArtistContainingIgnoreCaseOrTitleContainingIgnoreCase(search, search);
	}

}
