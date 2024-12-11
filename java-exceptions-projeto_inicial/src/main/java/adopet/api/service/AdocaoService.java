package adopet.api.service;

import adopet.api.dto.*;
import adopet.api.exception.AdocaoException;
import adopet.api.model.Adocao;
import adopet.api.model.Pet;
import adopet.api.model.StatusAdocao;
import adopet.api.model.Tutor;
import adopet.api.repository.AdocaoRepository;
import adopet.api.repository.PetRepository;
import adopet.api.repository.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdocaoService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private AdocaoRepository adocaoRepository;


    public List<AdocaoDTO> listarTodos() {

        return adocaoRepository.findAll().stream().map(AdocaoDTO::new).toList();
    }

    public AdocaoDTO listar(Long id) {

        return adocaoRepository.findById(id).stream().findFirst().map(AdocaoDTO::new).orElse(null);
    }

    public void solicitar(SolicitacaoDeAdocaoDTO dto) throws AdocaoException {

        //codigo Diogo
        /*Pet pet = petRepository.findById(dto.idPet()).orElseThrow(() ->
                new Exception("Pet não localizado"));
        var tutor = tutorRepository.findById(dto.idTutor()).orElseThrow(() ->
                new Exception("Tutor não localizado"));
        var tutorAdocoes = tutor.getAdocoes()
                .size();
        if (pet.getAdocao() != null) {
            var res = pet.getAdocao().getStatus().equals(StatusAdocao.AGUARDANDO_AVALIACAO);
            if (res) {
                throw new Exception("Pet aguardando avaliação para liberação");
            }
        }
        if (pet.getAdotado() == false && tutorAdocoes <= 2) {
            adocaoRepository.save(new Adocao(tutor, pet, dto.motivo()));
        } else {
            throw new Exception("Não é possível realizar a adoção");
        }*/

        //codigo do curso
        Pet pet2 = petRepository.getReferenceById(dto.idPet());
        Tutor tutor2 = tutorRepository.getReferenceById(dto.idTutor());
        //Pet ja adotado
        if (pet2.getAdotado()) {
            throw new AdocaoException("Pet já adotado");
        }
        //Pet com solicitação de adoçao em andamento
        Boolean petAdocaoEmAndamento = adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);
        if(pet2.getAdocao() != null){
            var status = pet2.getAdocao().getStatus().equals(StatusAdocao.AGUARDANDO_AVALIACAO);

        }
        if (petAdocaoEmAndamento) {
            throw new AdocaoException("Pet com adoção em andamento");
        }
        //Tutor com 2 adocoes aprovadas
        Integer tutorAdocoes = adocaoRepository.countByTutorIdAndStatus(dto.idTutor(),
                StatusAdocao.APROVADO);
        var tot = tutor2.getAdocoes().stream()
                .filter(adocao -> adocao.getStatus().equals(StatusAdocao.APROVADO))
                .count();
        if(tutorAdocoes == 2){
            throw new AdocaoException("Tutor com máximos de adoções");
        }

        adocaoRepository.save(new Adocao(tutor2, pet2, dto.motivo()));

    }

    public void aprovar(AprovarAdocaoDTO dto) {
        Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
        adocao.marcarComoAprovada();
        adocao.getPet().marcarComoAdotado();


    }

    public void reprovar(ReprovarAdocaoDTO dto) {
        Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
        adocao.marcarComoReprovada(dto.justificativa());
    }
}
