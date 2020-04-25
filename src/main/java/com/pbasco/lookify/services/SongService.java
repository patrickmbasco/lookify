package com.pbasco.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pbasco.lookify.models.Song;
import com.pbasco.lookify.repositories.SongRepository;

@Repository
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
	if(optionalSong.isPresent()) {
		return optionalSong.get();
	}
	else {
		return null;
		}
	}
	
	public Song addSong(Song melody) {
		return songRepository.save(melody);
	}

	public List<Song> getTopTen() {
		return songRepository.findTop10ByOrderByRatingDesc();

	}
	
	public List<Song> getSearchSongs(String artist){
		return songRepository.findByArtist(artist);
	}

	public void deleteSong(Long id) {
		songRepository.deleteById(id);		
	}
	
	

}
