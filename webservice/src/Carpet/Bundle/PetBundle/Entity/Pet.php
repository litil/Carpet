<?php

namespace Carpet\Bundle\PetBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
use Doctrine\Common\Collections\ArrayCollection;
use Gedmo\Mapping\Annotation as Gedmo;

/**
 * Pet
 *
 * @ORM\Table()
 * @ORM\Entity(repositoryClass="Carpet\Bundle\PetBundle\Entity\PetRepository")
 * @ORM\HasLifecycleCallbacks()
 */
class Pet
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    
    /**
     * @var datetime $created
     *
     * @Gedmo\Timestampable(on="create")
     * @ORM\Column(type="datetime")
     */
    private $created;
    
    
    /**
     * @var datetime $updated
     *
     * @Gedmo\Timestampable(on="update")
     * @ORM\Column(type="datetime")
     */
    private $updated;
    
    /**
     * @var string
     *
     * @ORM\Column(name="name", type="string", length=255)
     */
    private $name;

    /**
     *
     * @var string
     * 
     * @ORM\Column(name="slug", type="string", length=225)
     * @Gedmo\Slug(fields={"name"}, updatable=false, separator="-") 
     */
    private $slug;
    
    /**
     * @var integer
     *
     * @ORM\Column(name="mood", type="integer")
     */
    private $mood;
    
    /**
     *
     * @ORM\OneToMany(targetEntity="Possession", mappedBy="pet")
     */
    private $possessions;

    
    public function __construct() 
    {
        $this->possessions = new ArrayCollection();
    }

    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set name
     *
     * @param string $name
     * @return Pet
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * Get name
     *
     * @return string 
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * Set mood
     *
     * @param integer $mood
     * @return Pet
     */
    public function setMood($mood)
    {
        $this->mood = $mood;

        return $this;
    }

    /**
     * Get mood
     *
     * @return integer 
     */
    public function getMood()
    {
        return $this->mood;
    }

    /**
     * Add possessions
     *
     * @param \Carpet\Bundle\PetBundle\Entity\Possession $possessions
     * @return Pet
     */
    public function addPossession(\Carpet\Bundle\PetBundle\Entity\Possession $possessions)
    {
        $this->possessions[] = $possessions;

        return $this;
    }

    /**
     * Remove possessions
     *
     * @param \Carpet\Bundle\PetBundle\Entity\Possession $possessions
     */
    public function removePossession(\Carpet\Bundle\PetBundle\Entity\Possession $possessions)
    {
        $this->possessions->removeElement($possessions);
    }

    /**
     * Get possessions
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getPossessions()
    {
        return $this->possessions;
    }

    /**
     * Set slug
     *
     * @param string $slug
     * @return Pet
     */
    public function setSlug($slug)
    {
        $this->slug = $slug;

        return $this;
    }

    /**
     * Get slug
     *
     * @return string 
     */
    public function getSlug()
    {
        return $this->slug;
    }


    /**
     * Set created
     *
     * @param \DateTime $created
     * @return Pet
     */
    public function setCreated($created)
    {
        $this->created = $created;

        return $this;
    }

    /**
     * Get created
     *
     * @return \DateTime 
     */
    public function getCreated()
    {
        return $this->created;
    }

    /**
     * Set updated
     *
     * @param \DateTime $updated
     * @return Pet
     */
    public function setUpdated($updated)
    {
        $this->updated = $updated;

        return $this;
    }

    /**
     * Get updated
     *
     * @return \DateTime 
     */
    public function getUpdated()
    {
        return $this->updated;
    }
    
    public function __toString() 
    {
        return $this->id . '-' . $this->name;
    }
}
