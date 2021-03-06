package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.EtudiantRepo;
import com.example.Clubmanagement.Repositories.MemberRepo;
import com.example.Clubmanagement.Repositories.RoleRepo;
import com.example.Clubmanagement.entities.club.Club;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import com.example.Clubmanagement.entities.compte.generlAc.Etudiant;
import com.example.Clubmanagement.entities.compte.generlAc.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
private final MemberRepo memberRepo;
private final RoleRepo roleRepo;
private final EtudiantRepo etudiantRepo;



    public List<Members> getClubMembers(Long id,int pagenum,int size) {
        Pageable pageable = PageRequest.of(pagenum,size);
        Page<Members> page = this.memberRepo.findAllByClubid(id,pageable);
        List<Members> members= Arrays.asList(page.getContent().toArray(new Members[0]));
        return  members;
    }

    public List<Members> getClubRoles(String role) { return  this.memberRepo.findByRole(role); }
//saving new member
    public String saveMember(Members member) {
    String s="error";
    log.info("got Member {} for club {}",member.getStudentid(),member.getClubid());
        Members x= new Members();
    if (memberRepo.findByStudentidAndClubid(member.getStudentid(), member.getClubid() )==null){ x = this.memberRepo.save(member);}else return "Already member";
    if (x.getIdmembre()!=null){
        s="success";
    }
    return s;
    }




    public Members getMemberbyClubAndStudent(Long ids,Long idc){
        Members member =new Members();
        if (memberRepo.findByStudentidAndClubid(ids,idc)==null){
            member=new Members(Long.valueOf(-1),Long.valueOf(-1),null);
        }else member=memberRepo.findByStudentidAndClubid(ids,idc);
        return member;
    }


    public List<Members> getAllMembersByRole(String role) {
        return  this.memberRepo.findByRole(role);
    }

    public List<Members> getClubMemberRole(Long id,String Role,int pagenum,int size){
        Pageable pageable =PageRequest.of(pagenum,size);
        Page<Members> page = this.memberRepo.findByClubidAndRole(id,Role,pageable);
        List<Members>members =Arrays.asList(page.getContent().toArray(new Members[0]));
        return members;


    }

    public Members getmemberbystudentid(Long id){
        return this.memberRepo.findByStudentid(id);
    }




    public void addRoleToMember(String email,String Role,Long idClub){
        log.info("Added role{} to Student{}",Role,email);

        Role role=roleRepo.findByName(Role);
        Etudiant etudiant = this.etudiantRepo.findByEmail(email);
        Members members=new Members();
        if (etudiant!=null) {members=memberRepo.findByStudentidAndClubid(etudiant.getIdE(),idClub);
            if (members == null) {
                System.out.println("not a member");
                members=memberRepo.save(new Members(null,etudiant.getIdE(), idClub,Role));
            }else{
                //verifions si les memberes et deja president ou si il exist deja un president(si oui on va le render comme un membre normal)
            }
            members.setRole(Role);
        }
        else System.out.println("erreur etudiant no found");
    }

    public int getClubCount(Long idE) {
        return this.memberRepo.countByStudentid(idE);
    }

    public String saveComite(Members member) {
        String response="error";
        Members test = memberRepo.findByRoleAndAndClubid(member.getRole(),member.getClubid());
        if (test==null){
            memberRepo.save(member);
            log.info("saved " + member.toString());
            response="saved Successfully";
        }else{
            if (test.getStudentid()==member.getStudentid()){
               response= "Already " + test.getRole();
                log.info("Already comite " + member.toString());
            }else{
                Members verif= memberRepo.findByStudentidAndClubid(member.getStudentid(),member.getClubid());
                if (verif ==null){
            test.setRole("member");
            memberRepo.save(test);
            memberRepo.save(member);}else

                {     test.setRole("member");
                    memberRepo.save(test);
                    verif.setRole(member.getRole());
                    memberRepo.save(verif);
                 }
            response= "saved Successfully";
                log.info("Promoted  " + member.toString());
            }

        }
return response;
    }


    public String deleteMember(Long ids,Long idC) {
        Members members = memberRepo.findByStudentidAndClubid(ids,idC);
        if (members==null) return "member not found";
        else {memberRepo.delete(members);
        return "Deleted Successfully";
        }
    }
}
