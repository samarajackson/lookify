package com.samara.lookify.controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.samara.lookify.models.Song;
import com.samara.lookify.services.SongService;


@Controller
public class SongController {
	private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @RequestMapping("/")
    public String home() {
    	return "home.jsp";
    }
    @RequestMapping("/dashboard")
    public String index(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "allbooks.jsp";
    }
    @RequestMapping("/songs/{id}")
    public String show(Model model, @PathVariable(value="id") Long id) {
    	Song song = songService.findSong(id);
    	model.addAttribute("song",song);
    	return "show.jsp";
    }
    @RequestMapping("/songs/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Song song = songService.findSong(id);
        model.addAttribute("song", song);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.POST)
    public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            songService.updateSong(song.getId(),song.getTitle(),song.getArtist(),song.getRating());
            return "redirect:/";
        }
    }
    @RequestMapping(value="/songs/{id}/delete", method=RequestMethod.GET)
    public String destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
	@GetMapping("/songs/new/")
	public String index(@ModelAttribute("song") Song song) {
		return "index.jsp";
	}
	
	@PostMapping("/submit")
	public String submit(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/dashboard";
        }
	}
	@RequestMapping("/search")
	public String search(Model model, @RequestParam("search") String search) {
		List<Song> songs= songService.search(search);
		model.addAttribute("songs", songs);
		return "results.jsp";
	}
	@RequestMapping("/search/topTen")
	public String topsongs(Model model) {
		List<Song> topsongs = songService.top10();
		model.addAttribute("songs", topsongs);
	return "results.jsp";
	}

}
