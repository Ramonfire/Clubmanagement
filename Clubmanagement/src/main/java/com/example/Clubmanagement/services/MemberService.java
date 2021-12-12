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
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
private final MemberRepo memberRepo;
private final RoleRepo roleRepo;
private final EtudiantRepo etudiantRepo;



    public List<Members> getClubMembers(Long id) {
    return  memberRepo.findByClubid(id);
    }

    public List<Members> getClubRoles(String role) { return  this.memberRepo.findByRole(role); }

    public String saveMember(Members member) {
    String s="error";
            Members x = this.memberRepo.save(member);
    if (x.getIdmembre()!=null){
        s="success";
    }
    return s;
    }


    public List<Members> getAllMembersByRole(String role) {
        return  this.memberRepo.findByRole(role);
    }

    public List<Members> getClubMember(Long id,String Role){
        if(Role==null) return memberRepo.findByClubid(id);
        else return this.memberRepo.findByClubidAndRole(id,Role);


    }

    public Members getmemberbystudentid(Long id){
        return this.memberRepo.findByStudentid(id);
    }



//saving a new memeber
    public Members SaveNewMember(Members members){
    return  memberRepo.save(members);

    }

    public void addRoleToMember(String email,String Role,Long idClub){
        log.info("Added role{} to Student{}",Role,email);

        Role role=roleRepo.findByName(Role);
        Etudiant etudiant = this.etudiantRepo.findByEmail(email);
        Members members=new Members();
        if (etudiant!=null) {members=memberRepo.findByStudentidAndClubid(etudiant.getIdE(),idClub);
            if (members == null) {
                System.out.println("not a member");
                members=memberRepo.save(new Members(null,etudiant.getIdE(), idClub,Role,new ArrayList<>()));
            }else{
                //verifions si les memberes et deja president ou si il exist deja un president(si oui on va le render comme un membre normal)
            }
            members.getRoles().add(role);
        }
        else System.out.println("erreur etudiant no found");
    }

}
